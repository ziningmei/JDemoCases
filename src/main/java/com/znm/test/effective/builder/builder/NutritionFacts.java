package com.znm.test.effective.builder.builder;

/**
 * Created by jiang.qi on 2016/8/2.
 */
public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {

        private final int servingSize;
        private final int servings;

        private int calories=0;
        private int fat=0;
        private int sodium=0;
        private int carbohydrate=0;

        public Builder(int servings,int servingSize){
            this.servings=servings;
            this.servingSize=servingSize;
        }

        public Builder calories(int val){
            calories=val;
            return this;
        }
        public Builder fat(int val){
            fat=val;
            return this;
        }
        public Builder sodium(int val){
            sodium=val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate=val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder){
        servings=builder.servings;
        servingSize=builder.servingSize;
        fat=builder.fat;
        calories=builder.calories;
        sodium=builder.sodium;
        carbohydrate=builder.carbohydrate;
    }

    public static void main(String [] args){
        NutritionFacts cocaCola=new NutritionFacts.Builder(240,8).calories(100).sodium(35).carbohydrate(27).build();
    }
}
