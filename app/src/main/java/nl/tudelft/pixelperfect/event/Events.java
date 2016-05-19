package nl.tudelft.pixelperfect.event;

import java.util.ArrayList;

/**
 * Created by woute on 5/19/2016.
 */
public enum Events {
    FIRE {
        @Override
        public boolean contains(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof FireEvent) {
                    return true;
                }
            }
            return false;
        }
    },
    PLASMA {
        @Override
        public boolean contains(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof PlasmaLeakEvent) {
                    return true;
                }
            }
            return false;
        }
    },
    ASTROID {
        @Override
        public boolean contains(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof AsteroidFieldEvent) {
                    return true;
                }
            }
            return false;
        }
    },
    HOSTILE {
        @Override
        public boolean contains(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof HostileShipEvent) {
                    return true;
                }
            }
            return false;
        }
    };


    public abstract boolean contains(ArrayList<Event> log);
}
