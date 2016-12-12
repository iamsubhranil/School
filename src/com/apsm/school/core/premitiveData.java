package com.apsm.school.core;

/**
 *
 * @author Subhra
 */
public class premitiveData{
    static User [] users = new User[0];

    /**
     *
     * @param u
     */
    public static void addUser(User u){
        User [] tmp = new User[users.length+1];
        for(int i = 0;i<users.length;i++){
            tmp[i] = users[i];
        }
        tmp[users.length] = u;
        users = tmp;
    }
    
    /**
     *
     * @param us
     */
    public static void setUsers(User [] us){
        users = us;
    }
    
    /**
     *
     * @param unm
     * @return
     */
    public static boolean hasUser(String unm){
        for(int u = 0;u<users.length;u++){
            if(users[u].getUserName().equals(unm)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param unm
     * @param pwd
     * @return
     */
    public static boolean checkPass(String unm,String pwd){
        for(int u = 0;u<users.length;u++){
            if(users[u].getUserName().equals(unm)){
                if(users[u].getPasskey().equals(pwd)){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     *
     * @param unm
     * @return
     */
    public static User getUser(String unm){
        User u1 = new User();
        for(int u = 0;u<users.length;u++){
            if(users[u].getUserName().equals(unm)){
                return users[u];
            }
        }
        return u1;
    }
    
    /**
     *
     * @param u2
     */
    public static void updateUser(User u2){
        for(int u = 0;u<users.length;u++){
            if(users[u].equals(u2)){
                users[u] = u2;
            }
        }
    }
    
    /**
     *
     * @return
     */
    public static User[] getUsers(){
        return users;
    }
}