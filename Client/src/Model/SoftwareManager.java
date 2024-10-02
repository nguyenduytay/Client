package Model;
import java.util.ArrayList;
import java.util.List;

public class SoftwareManager {
    private List<String> installedSoftware;

    public SoftwareManager() {
        installedSoftware = new ArrayList<>();
    }

    public void installSoftware(String softwareName) {
        installedSoftware.add(softwareName);
        System.out.println("Installed: " + softwareName);
    }

    public void uninstallSoftware(String softwareName) {
        if (installedSoftware.remove(softwareName)) {
            System.out.println("Uninstalled: " + softwareName);
        } else {
            System.out.println(softwareName + " is not installed.");
        }
    }

    public void listInstalledSoftware() {
        System.out.println("Installed software: " + installedSoftware);
    }
}
