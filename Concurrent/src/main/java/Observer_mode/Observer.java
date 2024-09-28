package Observer_mode;

/**
 * @author weihanqiang
 * @date 2024/9/12
 */
interface Observer {
    public String getName();
    public void setName(String name);
    public void help(); //声明支援盟友方法
    public void beAttacked(AllyControlCenter acc); //声明遭受攻击方法
}

