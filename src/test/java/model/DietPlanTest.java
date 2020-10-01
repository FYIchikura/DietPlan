package model;

import model.DietPlan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DietPlanTest {

    private DietPlan dietPlan;

    @Before
    public void init() {
        this.dietPlan = new DietPlan();
    }


    @Test
    public void noDietTest() {
        Assert.assertEquals("", this.dietPlan.getDinner("","",""));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("","A",""));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("","A","A"));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("","","A"));
    }

    @Test
    public void noBreakfastnoLunchTest() {
        Assert.assertEquals("ABCD", this.dietPlan.getDinner("ABCD","",""));
        Assert.assertEquals("ADX", this.dietPlan.getDinner("XAD","",""));
    }

    @Test
    public void withDietWithBreakfastNoLunchTest() {
        Assert.assertEquals("ACD", this.dietPlan.getDinner("ABCD","B",""));
        Assert.assertEquals("AD", this.dietPlan.getDinner("XAD","X",""));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("XAD","J",""));
    }

    @Test
    public void withDietNoBreakfastWithLunchTest() {
        Assert.assertEquals("ACD", this.dietPlan.getDinner("ABCD","","B"));
        Assert.assertEquals("AD", this.dietPlan.getDinner("XAD","","X"));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("XAD","","J"));
    }

    @Test
    public void withDietWithBreakfastWithLunchTest() {
        Assert.assertEquals("CD", this.dietPlan.getDinner("ABCD","A","B"));
        Assert.assertEquals("DS", this.dietPlan.getDinner("XASD","A","X"));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("XAD","A","J"));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("XAD","J","A"));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("XAD","J","K"));
    }

    @Test
    public void withDietWithBreakfastWithLunchRepeatingFoodTest() {
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("ABCD","AA","B"));
        Assert.assertEquals("CHEATER", this.dietPlan.getDinner("XASD","X","AA"));
    }

}
