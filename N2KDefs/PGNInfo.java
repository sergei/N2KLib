package com.santacruzinstruments.scicalibrator.nmea2000.N2KLib.N2KDefs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties({"Type", "Missing",
        "RepeatingFieldSet1Size", "RepeatingFieldSet1StartField", "RepeatingFieldSet1CountField",
        "RepeatingFieldSet2Size", "RepeatingFieldSet2StartField", "RepeatingFieldSet2CountField"
})
public class PGNInfo 
{
    public int PGN;
    public String Id;
    public String Description;
    public boolean Complete;
    public int Length;
    public int RepeatingFields;

    @JsonProperty("Fields")
    public List<PGNField> pgnFields;


  public String toString()
  {
    int size = 0;
    if (pgnFields != null) {
      List<PGNField> fld = pgnFields;
        size = fld.size();
    }
    return("PGN:" + PGN + " Id:" + Id + " Description:" + Description + 
           " Complete:" + Complete + " Length:" + Length + 
           " RepeatingFields:" + RepeatingFields + " Field count:" + size); 
  }
}

