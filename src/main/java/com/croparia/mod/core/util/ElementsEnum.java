package com.croparia.mod.core.util;

import net.minecraft.util.StringRepresentable;

public enum ElementsEnum implements StringRepresentable {
   EMPTY("empty"),
   ELEMENTAL("elemental"),
   WATER("water"),
   AIR("air"),
   FIRE("fire"),
   EARTH("earth"),
   BLOOD("blood"),
   TIME("time");

   private final String name;

   private ElementsEnum(String name) {
      this.name = name;
   }

   public String getTranslationKey() {
      return this.name;
   }

	@Override
	public String getSerializedName() {
		return this.name;
	}
}
