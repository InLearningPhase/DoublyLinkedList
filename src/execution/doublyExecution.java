package execution;
import definition.doublyDefinition;

import java.util.Collections;

public class doublyExecution {
    public static void main(String[] args) {
        doublyDefinition<Integer> execution = new doublyDefinition<>();
        for (int i = 0; i < 10; i++) {
            execution.add(i);
        }
        System.out.println(execution);
    }
}
