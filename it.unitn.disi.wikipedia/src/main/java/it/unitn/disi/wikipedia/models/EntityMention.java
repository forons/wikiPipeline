/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.wikipedia.models;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EntityMention implements Serializable{
  
  String mention;
  String link;

  public String getMention() {
    return mention;
  }

  public void setMention(String mention) {
    this.mention = mention;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public String toString() {
    return "EntityMention{" + "mention=" + mention + ", link=" + link + '}';
  }
  
  
}
