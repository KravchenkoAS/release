package io.bootique.tools.release.model.maven.persistent.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

import io.bootique.tools.release.model.maven.persistent.Project;

/**
 * Class _ProjectDependency was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ProjectDependency extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<Project> DEPENDENCIES = Property.create("dependencies", Project.class);
    public static final Property<Project> DEPENDENCY_PROJECT = Property.create("dependencyProject", Project.class);


    protected Object dependencies;
    protected Object dependencyProject;

    public void setDependencies(Project dependencies) {
        setToOneTarget("dependencies", dependencies, true);
    }

    public Project getDependencies() {
        return (Project)readProperty("dependencies");
    }

    public void setDependencyProject(Project dependencyProject) {
        setToOneTarget("dependencyProject", dependencyProject, true);
    }

    public Project getDependencyProject() {
        return (Project)readProperty("dependencyProject");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "dependencies":
                return this.dependencies;
            case "dependencyProject":
                return this.dependencyProject;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "dependencies":
                this.dependencies = val;
                break;
            case "dependencyProject":
                this.dependencyProject = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.dependencies);
        out.writeObject(this.dependencyProject);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.dependencies = in.readObject();
        this.dependencyProject = in.readObject();
    }

}