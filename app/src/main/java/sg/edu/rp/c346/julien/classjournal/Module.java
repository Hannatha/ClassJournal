package sg.edu.rp.c346.julien.classjournal;

public class Module {

    private String moduleCode;
    private String moduleName;

    public Module(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }
}
