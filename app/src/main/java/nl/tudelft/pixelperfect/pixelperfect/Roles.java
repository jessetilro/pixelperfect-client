package nl.tudelft.pixelperfect.pixelperfect;

/**
 * Enums representing roles for more clarity in the program.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings("unused")
public enum Roles {
    GUNNER {
        @Override
        public void updateButtons(){
            RoleActivity.getGunnerView().setAlpha(0.5f);
            RoleActivity.getGunnerView().setEnabled(false);
        }
    },
    ENGINEER {
        @Override
        public void updateButtons(){
            RoleActivity.getEngineerView().setAlpha(0.5f);
            RoleActivity.getEngineerView().setEnabled(false);
        }
    },
    SCIENTIST {
        @Override
        public void updateButtons() {
            RoleActivity.getScientistView().setAlpha(0.5f);
            RoleActivity.getScientistView().setEnabled(false);
        }
    },
    JANITOR {
        @Override
        public void updateButtons() {
            RoleActivity.getScientistView().setAlpha(0.5f);
            RoleActivity.getScientistView().setEnabled(false);
        }
    };

    /**
     * Updates the buttons in the RoleActivity whenever a role is chosen. When a role is chosen
     * another role cannot be chosen anymore.
     */
    public abstract void updateButtons();
}
