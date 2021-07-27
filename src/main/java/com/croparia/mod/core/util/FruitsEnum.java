package com.croparia.mod.core.util;

import net.minecraft.util.StringRepresentable;

import java.util.Arrays;

public enum FruitsEnum implements StringRepresentable {
	   ORANGE(0, "orange"),
	   PEAR(1, "pear"),
	   CHERRY(2, "cherry"),
	   LEMON(3, "lemon"),
	   KIWI(4, "kiwi"),
	   APRICOT(5, "apricot"),
	   BANANA(6, "banana");

	   private static final FruitsEnum[] VALUES = Arrays.stream(values()).toArray((fruitId) -> {
	      return new FruitsEnum[fruitId];
	   });

	   private final int id;
	   private final String translationKey;
	
	   private FruitsEnum(int idIn, String translationKeyIn) {
	      this.id = idIn;
	      this.translationKey = translationKeyIn;
	   }
	
	   public int getId() {
	      return this.id;
	   }
	   
	   public String getTranslationKey() {
	      return this.translationKey;
	   }
	
		@Override
		public String getSerializedName() {
			return this.translationKey;
		}
	
	   public static FruitsEnum byId(int colorId) {
	      if (colorId < 0 || colorId >= VALUES.length) {
	         colorId = 0;
	      }
	
	      return VALUES[colorId];
	   }

}