package com.example.kafka_demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventRecord<K, V> {
  private K key;
  private V value;
}
