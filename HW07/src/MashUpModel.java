
/**
 *Class SpaceModel keeps track of the state of the MashUpPlayer simulation.
 *
 *Stuart Reges and Marty Stepp
 */

import java.util.*;
import java.awt.Point;
import java.awt.Color;
import java.lang.reflect.*;

public class MashUpModel {
    private int height;
    private int width;
    private MashUpPlayer[][] grid;
    private Map<MashUpPlayer, PrivateData> info;
    private SortedMap<String, Integer>thingCount;
    private boolean debugView;
    private int simulationCount;
    private static boolean created;
    
    public MashUpModel(int width, int height) {
        // this prevents someone from trying to create their own copy of
        // the GUI components
        if (created)
            throw new RuntimeException("Only one world allowed");
        created = true;

        this.width = width;
        this.height = height;
        grid = new MashUpPlayer[width][height];
        info = new HashMap<MashUpPlayer, PrivateData>();
        thingCount = new TreeMap<String, Integer>();
        this.debugView = false;
    }

    public Iterator<MashUpPlayer> iterator() {
        return info.keySet().iterator();
    }

    public Point getPoint(MashUpPlayer c) {
        return info.get(c).p;
    }

    public Color getColor(MashUpPlayer c) {
        return info.get(c).color;
    }

    public String getString(MashUpPlayer c) {
        return info.get(c).string;
    }

    public void add(int number, Class<? extends MashUpPlayer> thing) {
        Random r = new Random();
        MashUpPlayer.Direction[] directions = MashUpPlayer.Direction.values();
        if (info.size() + number > width * height)
            throw new RuntimeException("adding too many critters");
        for (int i = 0; i < number; i++) {
            MashUpPlayer next;
            try {
                next = makeMashUpPlayer(thing);
            } catch (Exception e) {
                System.out.println("ERROR: " + thing + " does not have" +
                                   " the appropriate constructor.");
                System.exit(1);
                return;
            }
            int x, y;
            do {
                x = r.nextInt(width);
                y = r.nextInt(height);
            } while (grid[x][y] != null);
            grid[x][y] = next;
            
            MashUpPlayer.Direction d = directions[r.nextInt(directions.length)];
            info.put(next, new PrivateData(new Point(x, y), d, 0,
                                           next.getColor(), next.toString()));
        }
        String name = thing.getName();
        if (!thingCount.containsKey(name))
            thingCount.put(name, number);
        else
            thingCount.put(name, thingCount.get(name) + number);
    }

    @SuppressWarnings("unchecked")
    private MashUpPlayer makeMashUpPlayer(Class thing) throws Exception {
        Constructor c = thing.getConstructors()[0];
        return (MashUpPlayer) c.newInstance(); 
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getAppearance(MashUpPlayer c) {
        // Override specified toString if debug flag is true
        if (!debugView) 
            return info.get(c).string;
        else {
            PrivateData data = info.get(c);
            if (data.direction == MashUpPlayer.Direction.NORTH) return "^";
            else if (data.direction == MashUpPlayer.Direction.SOUTH) return "v";
            else if (data.direction == MashUpPlayer.Direction.EAST) return ">";
            else return "<";
        }
    }
    
    public void toggleDebug() {
        this.debugView = !this.debugView;
    }

    private boolean inBounds(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    private boolean inBounds(Point p) {
        return inBounds(p.x, p.y);
    }

    // returns the result of rotating the given direction clockwise
    private MashUpPlayer.Direction rotate(MashUpPlayer.Direction d) {
        if (d == MashUpPlayer.Direction.NORTH) return MashUpPlayer.Direction.EAST;
        else if (d == MashUpPlayer.Direction.SOUTH) return MashUpPlayer.Direction.WEST;
        else if (d == MashUpPlayer.Direction.EAST) return MashUpPlayer.Direction.SOUTH;
        else return MashUpPlayer.Direction.NORTH;
    }

    private Point pointAt(Point p, MashUpPlayer.Direction d) {
        if (d == MashUpPlayer.Direction.NORTH) return new Point(p.x, p.y - 1);
        else if (d == MashUpPlayer.Direction.SOUTH) return new Point(p.x, p.y + 1);
        else if (d == MashUpPlayer.Direction.EAST) return new Point(p.x + 1, p.y);
        else return new Point(p.x - 1, p.y);
    }

    private Info getInfo(PrivateData data, Class original) {
        MashUpPlayer.Neighbor[] neighbors = new MashUpPlayer.Neighbor[4];
        MashUpPlayer.Direction d = data.direction;
        for (int i = 0; i < 4; i++) {
            neighbors[i] = getStatus(pointAt(data.p, d), original);
            d = rotate(d);
        }
        return new Info(neighbors, data.direction, data.fightCount);
    }

    private MashUpPlayer.Neighbor getStatus(Point p, Class original) {
        if (!inBounds(p))
            return MashUpPlayer.Neighbor.WALL;
        else if (grid[p.x][p.y] == null)
            return MashUpPlayer.Neighbor.EMPTY;
        else if (grid[p.x][p.y].getClass() == original)
            return MashUpPlayer.Neighbor.SAME;
        else
            return MashUpPlayer.Neighbor.OTHER;
    }

    @SuppressWarnings("unchecked")
    public void update() {
        simulationCount++;
        Object[] list = info.keySet().toArray();
        Collections.shuffle(Arrays.asList(list));
        Arrays.sort(list, new Comparator() {
                public int compare(Object x, Object y) {
                    return Math.min(10, info.get(x).fightCount) -
                        Math.min(10, info.get(y).fightCount);
                }
            });
        for (int i = 0; i < list.length; i++) {
            MashUpPlayer next = (MashUpPlayer)list[i];
            PrivateData data = info.get(next);
            if (data == null) {
                // happens when creature was infected earlier in this round
                continue;
            }
            Point p = data.p;
            Point p2 = pointAt(p, data.direction);
            MashUpPlayer.Action move = next.getMove(getInfo(data, next.getClass()));
            data.color = next.getColor();
            data.string = next.toString();
            if (move == MashUpPlayer.Action.LEFT)
                data.direction = rotate(rotate(rotate(data.direction)));
            else if (move == MashUpPlayer.Action.RIGHT)
                data.direction = rotate(data.direction);
            else if (move == MashUpPlayer.Action.MOVE) {
                if (inBounds(p2) && grid[p2.x][p2.y] == null) {
                    grid[p2.x][p2.y] = grid[p.x][p.y];
                    grid[p.x][p.y] = null;
                    data.p = p2;
                }
            } else if (move == MashUpPlayer.Action.FIGHT) {
                if (inBounds(p2) && grid[p2.x][p2.y] != null && grid[p2.x][p2.y].getClass() != next.getClass()) {
                    MashUpPlayer other = grid[p2.x][p2.y];
                    // remember the old MashUpPlayer's private data
                    PrivateData oldData = info.get(other);
                    // then remove that old MashUpPlayer
                    String c1 = other.getClass().getName();
                    thingCount.put(c1, thingCount.get(c1) - 1);
                    String c2 = next.getClass().getName();
                    thingCount.put(c2, thingCount.get(c2) + 1);
                    info.remove(other);
                    // and add a new one to the grid
                    try {
                        grid[p2.x][p2.y] = makeMashUpPlayer(next.getClass());
                    } catch (Exception e) {
                        throw new RuntimeException("" + e);
                    }
                    // and add to the map
                    info.put(grid[p2.x][p2.y], oldData);
                    // and update oldData for new critter's color/string
                    oldData.color = grid[p2.x][p2.y].getColor();
                    oldData.string = grid[p2.x][p2.y].toString();
                    // and remember that we fought a critter
                    data.fightCount++;
                }
            }
        }
    }

    public Set<Map.Entry<String, Integer>> getCounts() {
        return Collections.unmodifiableSet(thingCount.entrySet());
    }

    public int getSimulationCount() {
        return simulationCount;
    }

    private class PrivateData {
        public Point p;
        public MashUpPlayer.Direction direction;
        public int fightCount;
        public Color color;
        public String string;

        public PrivateData(Point p, MashUpPlayer.Direction d, int fightCount,
                           Color color, String string) {
            this.p = p;
            this.direction = d;
            this.fightCount = fightCount;
            this.color = color;
            this.string = string;
        }

        public String toString() {
            return p + " " + direction + " " + fightCount;
        }
    }

    // an object used to query a critter's state (neighbors, direction)
    private static class Info implements MashUpPlayerInfo {
        private MashUpPlayer.Neighbor[] neighbors;
        private MashUpPlayer.Direction direction;
        private int fightCount;

        public Info(MashUpPlayer.Neighbor[] neighbors, MashUpPlayer.Direction d,
                    int fightCount) {
            this.neighbors = neighbors;
            this.direction = d;
            this.fightCount = fightCount;
        }

        public MashUpPlayer.Neighbor getFront() {
            return neighbors[0];
        }

        public MashUpPlayer.Neighbor getBack() {
            return neighbors[2];
        }

        public MashUpPlayer.Neighbor getLeft() {
            return neighbors[3];
        }

        public MashUpPlayer.Neighbor getRight() {
            return neighbors[1];
        }

        public MashUpPlayer.Direction getDirection() {
            return direction;
        }

        public int getFightCount() {
            return fightCount;
        }
    }
}
