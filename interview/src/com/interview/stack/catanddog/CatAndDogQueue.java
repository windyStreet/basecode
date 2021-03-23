package com.interview.stack.catanddog;

public class CatAndDogQueue {

    public static void main(String[] args) {
        DogCatQueue dcq = new DogCatQueue();
        dcq.add(new Pet("cat"));
        dcq.add(new Pet("cat"));
        dcq.add(new Pet("dog"));
        dcq.add(new Pet("cat"));
        dcq.add(new Pet("dog"));
        dcq.add(new Pet("dog"));
        dcq.add(new Pet("dog"));
        dcq.add(new Pet("cat"));
        System.out.println(dcq.isCatQueueEmpty());
        System.out.println(dcq.isDogQueueEmpty());
        dcq.pollCat();
//        System.out.println(dcq.pollCat().getPetType());
//        System.out.println(dcq.pollCat().getPetType());
//        System.out.println(dcq.pollCat().getPetType());

        System.out.println(dcq.pollAll().getPetType());
//        System.out.println(dcq.pollAll().getPetType());
//        System.out.println(dcq.pollAll().getPetType());
//        System.out.println(dcq.pollAll().getPetType());
//        System.out.println(dcq.pollAll().getPetType());
//        System.out.println(dcq.pollAll().getPetType());
//        System.out.println(dcq.pollAll().getPetType());
//        System.out.println(dcq.pollAll().getPetType());
        System.out.println(dcq.isCatQueueEmpty());
        System.out.println(dcq.isDogQueueEmpty());
    }
}


