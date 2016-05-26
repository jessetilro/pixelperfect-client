package nl.tudelft.pixelperfect.event;

import java.util.ArrayList;

/**
 * Enums to pass type of events.
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
                if (event instanceof PlasmaLeakEvent) {
                    Event ret = event;
                    log.remove(event);
                    return ret;
                }
            }
            return null;
        }
    },
    ASTEROID {
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
                if (event instanceof AsteroidFieldEvent) {
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
                if (event instanceof HostileShipEvent) {
                    Event ret = event;
                    log.remove(event);
                    return ret;
                }
            }
            return null;
        }
    };

    /**
     * Checks whether the eventlog contains an Event.
     *
     * @param log the log to do the check in.
     * @return a boolean.
     */
    public abstract boolean contains(ArrayList<Event> log);

    /**
     * Pops the event of the EventLog.
     *
     * @param log the log to pop.
     * @return the log that was popped.
     */
    public abstract Event pop(ArrayList<Event> log);
}
