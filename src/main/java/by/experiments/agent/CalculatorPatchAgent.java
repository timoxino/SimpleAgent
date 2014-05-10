package by.experiments.agent;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * Simple example of Agent that makes replacement of Calculator implementation.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 4/6/13
 */
public class CalculatorPatchAgent
{

    public static void premain(String args, Instrumentation instrumentation) throws Exception
    {
        // premain is not in use
    }

    @SuppressWarnings("UnusedDeclaration")
    public static void agentmain(String args, Instrumentation instrumentation) throws Exception
    {
        byte[] bytecode = toByteArray(CalculatorPatchAgent.class.getResourceAsStream("Calculator.class.fixed"));
        ClassDefinition classDefinition = new ClassDefinition(Class.forName("example.Calculator"), bytecode);
        instrumentation.redefineClasses(classDefinition);
    }
}
