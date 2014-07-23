package by.experiments.agent.util;

import by.experiments.agent.exception.ArgumentNotFoundException;

/**
 * Provides some util methods for {@link by.experiments.agent.ClassRedefineAgent}.
 *
 * @author Tsimafei_Shchytkavets
 */
public class AgentUtils
{
    public static String buildArgumentsString(String className, String fixFileName)
    {
        final StringBuilder arguments = new StringBuilder();
        arguments.append(AgentConstants.CLASS_NAME_ARGUMENT);
        arguments.append("=");
        arguments.append(className);
        arguments.append(";");
        arguments.append(AgentConstants.FIX_FILE_NAME_ARGUMENT);
        arguments.append("=");
        arguments.append(fixFileName);
        return arguments.toString();
    }

    public static String getClassName(String args)
    {
        if (!args.contains(AgentConstants.CLASS_NAME_ARGUMENT))
        {
            throw new ArgumentNotFoundException(AgentConstants.CLASS_NAME_ARGUMENT);
        }
        return extractArgument(args, AgentConstants.CLASS_NAME_ARGUMENT);
    }

    public static String getFixFileName(String args)
    {
        if (!args.contains(AgentConstants.FIX_FILE_NAME_ARGUMENT))
        {
            throw new ArgumentNotFoundException(AgentConstants.FIX_FILE_NAME_ARGUMENT);
        }
        return extractArgument(args, AgentConstants.FIX_FILE_NAME_ARGUMENT);
    }

    private static String extractArgument(String args, String arg)
    {
        final String[] arguments = args.split(";");
        for (String argument : arguments)
        {
            if (argument.startsWith(arg))
            {
                return argument.split("=")[1];
            }
        }
        return null;
    }
}
