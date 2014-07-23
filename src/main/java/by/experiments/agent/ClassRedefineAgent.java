package by.experiments.agent;

import by.experiments.agent.util.AgentUtils;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * Agent that makes replacement of class metadata in <code>permgen</code>.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 4/6/13
 */
public class ClassRedefineAgent
{

    public static void premain(String args, Instrumentation instrumentation) throws Exception
    {
        // premain is not in use
    }

    @SuppressWarnings("UnusedDeclaration")
    public static void agentmain(String args, Instrumentation instrumentation) throws Exception
    {
        byte[] bytecode = toByteArray(ClassRedefineAgent.class.getResourceAsStream(AgentUtils.getFixFileName(args)));
        ClassDefinition classDefinition = new ClassDefinition(Class.forName(AgentUtils.getClassName(args)), bytecode);
        instrumentation.redefineClasses(classDefinition);
    }
}
