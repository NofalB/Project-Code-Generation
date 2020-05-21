package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-21T17:34:38.187Z[GMT]")
public class Transaction   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("Sender")
  private String sender = null;

  @JsonProperty("Receiver")
  private String receiver = null;

  @JsonProperty("ReceiverName")
  private String receiverName = null;

  @JsonProperty("Amount")
  private Double amount = null;

  @JsonProperty("Performedby")
  private Integer performedby = null;

  public Transaction id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Transaction sender(String sender) {
    this.sender = sender;
    return this;
  }

  /**
   * Get sender
   * @return sender
  **/
  @ApiModelProperty(value = "")
  
    public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public Transaction receiver(String receiver) {
    this.receiver = receiver;
    return this;
  }

  /**
   * Get receiver
   * @return receiver
  **/
  @ApiModelProperty(value = "")
  
    public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public Transaction receiverName(String receiverName) {
    this.receiverName = receiverName;
    return this;
  }

  /**
   * Get receiverName
   * @return receiverName
  **/
  @ApiModelProperty(value = "")
  
    public String getReceiverName() {
    return receiverName;
  }

  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }

  public Transaction amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")
  
    public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Transaction performedby(Integer performedby) {
    this.performedby = performedby;
    return this;
  }

  /**
   * Get performedby
   * @return performedby
  **/
  @ApiModelProperty(value = "")
  
    public Integer getPerformedby() {
    return performedby;
  }

  public void setPerformedby(Integer performedby) {
    this.performedby = performedby;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.sender, transaction.sender) &&
        Objects.equals(this.receiver, transaction.receiver) &&
        Objects.equals(this.receiverName, transaction.receiverName) &&
        Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.performedby, transaction.performedby);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sender, receiver, receiverName, amount, performedby);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
    sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
    sb.append("    receiverName: ").append(toIndentedString(receiverName)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    performedby: ").append(toIndentedString(performedby)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
