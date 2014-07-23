package by.experiments.agent.exception;

/**
 * Should be thrown when required argument hasn't been found.
 *
 * @author Tsimafei_Shchytkavets
 */
public class ArgumentNotFoundException extends RuntimeException
{
    private static final String POSTFIX = " argument hasn't been found.";

    public ArgumentNotFoundException(String message)
    {
        super(message + POSTFIX);
    }
}
