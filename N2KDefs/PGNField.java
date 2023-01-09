package com.santacruzinstruments.scicalibrator.nmea2000.N2KLib.N2KDefs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({"RangeMin", "RangeMax", "Offset", "BitLengthVariable", "Condition", "EnumBitValues", "BitLengthField"})
public class PGNField
{
    public int Order;
    public String Id;
    public String Name;
    public int BitLength;
    public int BitOffset;
    public int BitStart;
    public String Match;
    public String Type;
    public String Units;
    public double Resolution;
    public boolean Signed;
    public String Description;
    public List<PGNEnumPair> EnumValues;
}

