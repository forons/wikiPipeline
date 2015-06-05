/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.wikipedia.models;

import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EntityList {
  Map<String,List<EntityMention>> list;

  public Map<String, List<EntityMention>> getList() {
    return list;
  }

  public void setList(Map<String, List<EntityMention>> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "EntityList{" + "list=" + list + '}';
  }

  
 
  
}
