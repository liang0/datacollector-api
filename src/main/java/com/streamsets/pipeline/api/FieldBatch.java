/*
 * Copyright 2018 StreamSets Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.api;

/**
 * Field batch is used by {@FieldProcesor} to transform individual fields rather then whole records.
 *
 * Unlike {@Batch} the API uses cursor style API so that the caller can immediately specify what action should happen
 * for each field inside the iteration.
 */
public interface FieldBatch {

  /**
   * Move the cursor to next field.
   *
   * @return True if there is a next field, false otherwise.
   */
  public boolean next();

  /**
   * Field path of the filed that the cursor is currently pointing to.
   *
   * @return Path string or null if the cursor is invalid.
   */
  public String getFieldPath();

  /**
   * Field that the cursor is currently pointing to.
   *
   * @return Field or null if the cursor is invalid.
   */
  public Field getField();

  /**
   * Return record associated with the field.
   *
   * @return Record where the field is from.
   */
  public Record getRecord();

  /**
   * Replace the field the cursor is currently pointing to with the replacement.
   *
   * @param replacement Replacement field.
   */
  public void replace(Field replacement);

  /**
   * Drop the field that the cursor is pointing to.
   */
  public void drop();
}