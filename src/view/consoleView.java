package view;

import base.Personality;
import base.PersonalityType;

import java.util.Random;

/**
 * Created by mauriciog on 8/17/15.
 */
public class consoleView {

    public static void main(String[] args) {
        final Random random = new Random();
        Personality p;
        int x;
        for (int i = 0; i < 10; i++) {
            x = random.nextInt(4);
            switch (x) {
                case 0:
                    p = Personality.getInstance(PersonalityType.Adaptable);
                case 1:
                    p = Personality.getInstance(PersonalityType.Chaotic);
                case 2:
                    p = Personality.getInstance(PersonalityType.Static);
                default:
                    p = Personality.getInstance(PersonalityType.Unyielding);
            }
        }
    }

}
