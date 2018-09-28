package teammates.ui.template;

import java.util.List;

public class RepliesDiv {
    private String name;
    private String desc;
    private String id;
    
    
    private String createdAtDateString;
    private String createdAtDateStamp;
    private String createdAtFullDateTimeString;
    
    
    private List<ElementTag> actions;

    public RepliesDiv(String name, String id, String desc, List<ElementTag> actionsParam) {
        
        this.name = name;
        this.desc = desc;
        this.id = id;
        this.actions = actionsParam;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
    public String getCreatedAtDateString() {
        return createdAtDateString;
    }

    public String getCreatedAtDateStamp() {
        return createdAtDateStamp;
    }

    public String getCreatedAtFullDateTimeString() {
        return createdAtFullDateTimeString;
    }

    public List<ElementTag> getActions() {
        return actions;
    }

}