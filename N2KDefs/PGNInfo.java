package com.santacruzinstruments.N2KLib.N2KDefs;
import androidx.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties({
        "Missing",
        "RepeatingFieldSet2Size", "RepeatingFieldSet2StartField", "RepeatingFieldSet2CountField"
})
public class PGNInfo 
{
    public enum PGNType{
        Single,
        Fast,
        ISO
    };

    public int PGN;
    public String Id;
    public String Description;
    public boolean Complete;
    public int Length;

    public PGNType Type;

    @JsonProperty("RepeatingFieldSet1StartField")
    public int RepeatingFieldSetStartField;

    @JsonProperty("RepeatingFieldSet1Size")
    public int RepeatingFieldSetSize;

    @JsonProperty("RepeatingFieldSet1CountField")
    public int RepeatingFieldSetCountField;

    @JsonProperty("Fields")
    public List<PGNField> pgnFields;


  @NonNull
  public String toString()
  {
    int size = 0;
    if (pgnFields != null) {
      List<PGNField> fld = pgnFields;
        size = fld.size();
    }
    return("PGN:" + PGN + " Id:" + Id + " Description:" + Description + 
           " Complete:" + Complete + " Length:" + Length + 
           " RepeatingFieldSetStartField:" + RepeatingFieldSetStartField +
           " RepeatingFieldSetSize:" + RepeatingFieldSetSize +
           " RepeatingFieldSetCountField:" + RepeatingFieldSetCountField +
            " Field count:" + size);
  }
}

