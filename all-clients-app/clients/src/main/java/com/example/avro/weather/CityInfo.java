/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.avro.weather;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class CityInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4196266235264269822L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CityInfo\",\"namespace\":\"com.example.avro.weather\",\"fields\":[{\"name\":\"city\",\"type\":\"string\"},{\"name\":\"population\",\"type\":\"string\"},{\"name\":\"isMetro\",\"type\":\"boolean\"},{\"name\":\"maxTempp\",\"type\":\"int\",\"default\":0},{\"name\":\"minTempp\",\"type\":\"int\",\"default\":0},{\"name\":\"transport\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CityInfo> ENCODER =
      new BinaryMessageEncoder<CityInfo>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CityInfo> DECODER =
      new BinaryMessageDecoder<CityInfo>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CityInfo> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CityInfo> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CityInfo> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CityInfo>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CityInfo to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CityInfo from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CityInfo instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CityInfo fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence city;
  @Deprecated public java.lang.CharSequence population;
  @Deprecated public boolean isMetro;
  @Deprecated public int maxTempp;
  @Deprecated public int minTempp;
  @Deprecated public java.lang.CharSequence transport;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CityInfo() {}

  /**
   * All-args constructor.
   * @param city The new value for city
   * @param population The new value for population
   * @param isMetro The new value for isMetro
   * @param maxTempp The new value for maxTempp
   * @param minTempp The new value for minTempp
   * @param transport The new value for transport
   */
  public CityInfo(java.lang.CharSequence city, java.lang.CharSequence population, java.lang.Boolean isMetro, java.lang.Integer maxTempp, java.lang.Integer minTempp, java.lang.CharSequence transport) {
    this.city = city;
    this.population = population;
    this.isMetro = isMetro;
    this.maxTempp = maxTempp;
    this.minTempp = minTempp;
    this.transport = transport;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return city;
    case 1: return population;
    case 2: return isMetro;
    case 3: return maxTempp;
    case 4: return minTempp;
    case 5: return transport;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: city = (java.lang.CharSequence)value$; break;
    case 1: population = (java.lang.CharSequence)value$; break;
    case 2: isMetro = (java.lang.Boolean)value$; break;
    case 3: maxTempp = (java.lang.Integer)value$; break;
    case 4: minTempp = (java.lang.Integer)value$; break;
    case 5: transport = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'city' field.
   * @return The value of the 'city' field.
   */
  public java.lang.CharSequence getCity() {
    return city;
  }


  /**
   * Sets the value of the 'city' field.
   * @param value the value to set.
   */
  public void setCity(java.lang.CharSequence value) {
    this.city = value;
  }

  /**
   * Gets the value of the 'population' field.
   * @return The value of the 'population' field.
   */
  public java.lang.CharSequence getPopulation() {
    return population;
  }


  /**
   * Sets the value of the 'population' field.
   * @param value the value to set.
   */
  public void setPopulation(java.lang.CharSequence value) {
    this.population = value;
  }

  /**
   * Gets the value of the 'isMetro' field.
   * @return The value of the 'isMetro' field.
   */
  public boolean getIsMetro() {
    return isMetro;
  }


  /**
   * Sets the value of the 'isMetro' field.
   * @param value the value to set.
   */
  public void setIsMetro(boolean value) {
    this.isMetro = value;
  }

  /**
   * Gets the value of the 'maxTempp' field.
   * @return The value of the 'maxTempp' field.
   */
  public int getMaxTempp() {
    return maxTempp;
  }


  /**
   * Sets the value of the 'maxTempp' field.
   * @param value the value to set.
   */
  public void setMaxTempp(int value) {
    this.maxTempp = value;
  }

  /**
   * Gets the value of the 'minTempp' field.
   * @return The value of the 'minTempp' field.
   */
  public int getMinTempp() {
    return minTempp;
  }


  /**
   * Sets the value of the 'minTempp' field.
   * @param value the value to set.
   */
  public void setMinTempp(int value) {
    this.minTempp = value;
  }

  /**
   * Gets the value of the 'transport' field.
   * @return The value of the 'transport' field.
   */
  public java.lang.CharSequence getTransport() {
    return transport;
  }


  /**
   * Sets the value of the 'transport' field.
   * @param value the value to set.
   */
  public void setTransport(java.lang.CharSequence value) {
    this.transport = value;
  }

  /**
   * Creates a new CityInfo RecordBuilder.
   * @return A new CityInfo RecordBuilder
   */
  public static com.example.avro.weather.CityInfo.Builder newBuilder() {
    return new com.example.avro.weather.CityInfo.Builder();
  }

  /**
   * Creates a new CityInfo RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CityInfo RecordBuilder
   */
  public static com.example.avro.weather.CityInfo.Builder newBuilder(com.example.avro.weather.CityInfo.Builder other) {
    if (other == null) {
      return new com.example.avro.weather.CityInfo.Builder();
    } else {
      return new com.example.avro.weather.CityInfo.Builder(other);
    }
  }

  /**
   * Creates a new CityInfo RecordBuilder by copying an existing CityInfo instance.
   * @param other The existing instance to copy.
   * @return A new CityInfo RecordBuilder
   */
  public static com.example.avro.weather.CityInfo.Builder newBuilder(com.example.avro.weather.CityInfo other) {
    if (other == null) {
      return new com.example.avro.weather.CityInfo.Builder();
    } else {
      return new com.example.avro.weather.CityInfo.Builder(other);
    }
  }

  /**
   * RecordBuilder for CityInfo instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CityInfo>
    implements org.apache.avro.data.RecordBuilder<CityInfo> {

    private java.lang.CharSequence city;
    private java.lang.CharSequence population;
    private boolean isMetro;
    private int maxTempp;
    private int minTempp;
    private java.lang.CharSequence transport;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.avro.weather.CityInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.city)) {
        this.city = data().deepCopy(fields()[0].schema(), other.city);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.population)) {
        this.population = data().deepCopy(fields()[1].schema(), other.population);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.isMetro)) {
        this.isMetro = data().deepCopy(fields()[2].schema(), other.isMetro);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.maxTempp)) {
        this.maxTempp = data().deepCopy(fields()[3].schema(), other.maxTempp);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.minTempp)) {
        this.minTempp = data().deepCopy(fields()[4].schema(), other.minTempp);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.transport)) {
        this.transport = data().deepCopy(fields()[5].schema(), other.transport);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing CityInfo instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.avro.weather.CityInfo other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.city)) {
        this.city = data().deepCopy(fields()[0].schema(), other.city);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.population)) {
        this.population = data().deepCopy(fields()[1].schema(), other.population);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.isMetro)) {
        this.isMetro = data().deepCopy(fields()[2].schema(), other.isMetro);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.maxTempp)) {
        this.maxTempp = data().deepCopy(fields()[3].schema(), other.maxTempp);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.minTempp)) {
        this.minTempp = data().deepCopy(fields()[4].schema(), other.minTempp);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.transport)) {
        this.transport = data().deepCopy(fields()[5].schema(), other.transport);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'city' field.
      * @return The value.
      */
    public java.lang.CharSequence getCity() {
      return city;
    }


    /**
      * Sets the value of the 'city' field.
      * @param value The value of 'city'.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder setCity(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.city = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'city' field has been set.
      * @return True if the 'city' field has been set, false otherwise.
      */
    public boolean hasCity() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'city' field.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder clearCity() {
      city = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'population' field.
      * @return The value.
      */
    public java.lang.CharSequence getPopulation() {
      return population;
    }


    /**
      * Sets the value of the 'population' field.
      * @param value The value of 'population'.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder setPopulation(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.population = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'population' field has been set.
      * @return True if the 'population' field has been set, false otherwise.
      */
    public boolean hasPopulation() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'population' field.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder clearPopulation() {
      population = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'isMetro' field.
      * @return The value.
      */
    public boolean getIsMetro() {
      return isMetro;
    }


    /**
      * Sets the value of the 'isMetro' field.
      * @param value The value of 'isMetro'.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder setIsMetro(boolean value) {
      validate(fields()[2], value);
      this.isMetro = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'isMetro' field has been set.
      * @return True if the 'isMetro' field has been set, false otherwise.
      */
    public boolean hasIsMetro() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'isMetro' field.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder clearIsMetro() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'maxTempp' field.
      * @return The value.
      */
    public int getMaxTempp() {
      return maxTempp;
    }


    /**
      * Sets the value of the 'maxTempp' field.
      * @param value The value of 'maxTempp'.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder setMaxTempp(int value) {
      validate(fields()[3], value);
      this.maxTempp = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'maxTempp' field has been set.
      * @return True if the 'maxTempp' field has been set, false otherwise.
      */
    public boolean hasMaxTempp() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'maxTempp' field.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder clearMaxTempp() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'minTempp' field.
      * @return The value.
      */
    public int getMinTempp() {
      return minTempp;
    }


    /**
      * Sets the value of the 'minTempp' field.
      * @param value The value of 'minTempp'.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder setMinTempp(int value) {
      validate(fields()[4], value);
      this.minTempp = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'minTempp' field has been set.
      * @return True if the 'minTempp' field has been set, false otherwise.
      */
    public boolean hasMinTempp() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'minTempp' field.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder clearMinTempp() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'transport' field.
      * @return The value.
      */
    public java.lang.CharSequence getTransport() {
      return transport;
    }


    /**
      * Sets the value of the 'transport' field.
      * @param value The value of 'transport'.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder setTransport(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.transport = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'transport' field has been set.
      * @return True if the 'transport' field has been set, false otherwise.
      */
    public boolean hasTransport() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'transport' field.
      * @return This builder.
      */
    public com.example.avro.weather.CityInfo.Builder clearTransport() {
      transport = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CityInfo build() {
      try {
        CityInfo record = new CityInfo();
        record.city = fieldSetFlags()[0] ? this.city : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.population = fieldSetFlags()[1] ? this.population : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.isMetro = fieldSetFlags()[2] ? this.isMetro : (java.lang.Boolean) defaultValue(fields()[2]);
        record.maxTempp = fieldSetFlags()[3] ? this.maxTempp : (java.lang.Integer) defaultValue(fields()[3]);
        record.minTempp = fieldSetFlags()[4] ? this.minTempp : (java.lang.Integer) defaultValue(fields()[4]);
        record.transport = fieldSetFlags()[5] ? this.transport : (java.lang.CharSequence) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CityInfo>
    WRITER$ = (org.apache.avro.io.DatumWriter<CityInfo>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CityInfo>
    READER$ = (org.apache.avro.io.DatumReader<CityInfo>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.city);

    out.writeString(this.population);

    out.writeBoolean(this.isMetro);

    out.writeInt(this.maxTempp);

    out.writeInt(this.minTempp);

    out.writeString(this.transport);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.city = in.readString(this.city instanceof Utf8 ? (Utf8)this.city : null);

      this.population = in.readString(this.population instanceof Utf8 ? (Utf8)this.population : null);

      this.isMetro = in.readBoolean();

      this.maxTempp = in.readInt();

      this.minTempp = in.readInt();

      this.transport = in.readString(this.transport instanceof Utf8 ? (Utf8)this.transport : null);

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.city = in.readString(this.city instanceof Utf8 ? (Utf8)this.city : null);
          break;

        case 1:
          this.population = in.readString(this.population instanceof Utf8 ? (Utf8)this.population : null);
          break;

        case 2:
          this.isMetro = in.readBoolean();
          break;

        case 3:
          this.maxTempp = in.readInt();
          break;

        case 4:
          this.minTempp = in.readInt();
          break;

        case 5:
          this.transport = in.readString(this.transport instanceof Utf8 ? (Utf8)this.transport : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










