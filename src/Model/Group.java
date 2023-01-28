package Model;

import java.util.ArrayList;
import java.util.HashSet;

public class Group {

    private HashSet<Integer> groupList;

    public Group() {
        this.groupList = new HashSet<>();
    }

    public Group(HashSet<Integer> groupList) {
        this.groupList = groupList;
    }

    public HashSet<Integer> getGroupList() {
        return groupList;
    }

    public void setGroupList(HashSet<Integer> groupList) {
        this.groupList = groupList;
    }

    public void addMember(int newMemberID) {
        groupList.add(newMemberID);
    }

    public void removeMember(int memberId){
        groupList.remove(memberId);
    }

}
