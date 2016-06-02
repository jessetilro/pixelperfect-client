package nl.tudelft.pixelperfect.event;

import java.util.ArrayList;

/**
 * Enums to pass type of events.
 *
 * @author Wouter Zirkzee
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
        public Event peek(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof FireEvent) {
                    return event;
                }
            }
            return null;
        }

        @Override
        public Event pop(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof FireEvent) {
                    log.remove(event);
                    return event;
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
        public Event peek(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof PlasmaLeakEvent) {
                    return event;
                }
            }
            return null;
        }

        @Override
        public Event pop(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof PlasmaLeakEvent) {
                    log.remove(event);
                    return event;
                }
            }
            return null;
        }
    },
    ASTEROID {
        @Override
        public boolean contains(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof AsteroidImpactEvent) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Event peek(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof AsteroidImpactEvent) {
                    return event;
                }
            }
            return null;
        }

        @Override
        public Event pop(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof AsteroidImpactEvent) {
                    log.remove(event);
                    return event;
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
        public Event peek(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof HostileShipEvent) {
                    return event;
                }
            }
            return null;
        }

        @Override
        public Event pop(ArrayList<Event> log) {
            for (Event event : log) {
                if (event instanceof HostileShipEvent) {
                    log.remove(event);
                    return event;
                }
            }
            return null;
        }
    };

    /**
     * Checks whether the event log contains an Event.
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

    /**
     * Peeks the event with the right type of EventLog. Peeking only retrieves the event and does
     * not remove it from the EventLog.
     *
     * @param log the log to peek from.
     * @return and Event from the EventLog.
     */
    public abstract Event peek(ArrayList<Event> log);
}
