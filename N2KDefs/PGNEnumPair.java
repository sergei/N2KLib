package com.santacruzinstruments.scicalibrator.nmea2000.N2KLib.N2KDefs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PGNEnumPair
{
  @JsonProperty("value")
  public int Value;
  @JsonProperty("name")
  public String Name;
}

