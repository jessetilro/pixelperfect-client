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

        @Override
        public Event pop(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof FireEvent) {
                    Event ret = event;
                    log.remove(event);
                    return ret;
                }
            }
            return null;
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

        @Override
        public Event pop(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof FireEvent) {
                    Event ret = event;
                    log.remove(event);
                    return ret;
                }
            }
            return null;
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

        @Override
        public Event pop(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof FireEvent) {
                    Event ret = event;
                    log.remove(event);
                    return ret;
                }
            }
            return null;
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

        @Override
        public Event pop(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof FireEvent) {
                    Event ret = event;
                    log.remove(event);
                    return ret;
                }
            }
            return null;
        }
    };

    public abstract boolean contains(ArrayList<Event> log);

    public abstract Event pop(ArrayList<Event> log);
}
