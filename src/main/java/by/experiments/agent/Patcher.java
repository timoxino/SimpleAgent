package by.experiments.agent;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.io.IOException;
import java.util.List;

/**
 * Paths running application using jar with Agent.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 4/6/13
 */
public class Patcher
{
    private static final String jarFilePath = "d:/IHG/m2repository/by/experiments/agent/1.0-SNAPSHOT/agent-1.0-SNAPSHOT-jar-with-dependencies.jar";

    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException
    {
        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        String pid = null; // need the process id
        for (VirtualMachineDescriptor desc : vms)
        {
            // Find the relevant JVM Process
            if (desc.displayName().contains("program-to-patch"))
            {
                pid = desc.id();
                break;
            }
        }
        if (pid != null)
        {
            VirtualMachine vm = VirtualMachine.attach(pid);
            vm.loadAgent(jarFilePath);
            vm.detach();
        }
    }
}
