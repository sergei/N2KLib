package com.santacruzinstruments.N2KLib.N2KDefs;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({ "Comment", "CreatorCode",  "License",  "Version"})
  public class PGNDefinitions
{
    @JsonProperty("PGNs")
    public List<PGNInfo> pgnInfo;
}

