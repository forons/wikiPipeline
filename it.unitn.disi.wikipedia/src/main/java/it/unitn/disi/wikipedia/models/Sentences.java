/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.wikipedia.models;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sentences {
  
  List<String> sentence;

  public List<String> getSentence() {
    return sentence;
  }

  public void setSentence(List<String> sentence) {
    this.sentence = sentence;
  }

  @Override
  public String toString() {
    return "Sentences{" + "sentence=" + sentence + '}';
  }
  
  
  
}
