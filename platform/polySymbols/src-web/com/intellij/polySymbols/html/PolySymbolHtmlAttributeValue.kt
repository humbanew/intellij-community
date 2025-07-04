// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.polySymbols.html

import com.intellij.openapi.util.NlsSafe
import com.intellij.polySymbols.html.impl.PolySymbolHtmlAttributeValueImpl
import com.intellij.polySymbols.query.PolySymbolMatch

/**
 * An interface holding information about Poly Symbol HTML attribute value.
 *
 * It can provide information about:
 * - kind ([PolySymbolHtmlAttributeValue.Kind]: `PLAIN`, `EXPRESSION`, `NO_VALUE`),
 * - type ([PolySymbolHtmlAttributeValue.Type]: `BOOLEAN`, `NUMBER`, `STRING`, `ENUM`, `SYMBOL`, `COMPLEX`, `OF_MATCH`),
 * - whether the attribute value is required,
 * - a default value
 * - the expected result type of value expression in the appropriate language. If `COMPLEX` type is set,
 * the value of `langType` property will be used and if OF_MATCH,
 * the type of the symbol will be used.
 *
 * When merging information from several segments in the [PolySymbolMatch],
 * first non-null property values take precedence.
 * By default - when all properties are `null` - attribute value is of plain type and is required.
 */
/*
 * INAPPLICABLE_JVM_NAME -> https://youtrack.jetbrains.com/issue/KT-31420
 **/
@Suppress("INAPPLICABLE_JVM_NAME")
interface PolySymbolHtmlAttributeValue {
  /**
   * Default: `PLAIN`
   */
  val kind: Kind?
    get() = null

  val type: Type?
    get() = null

  /** Default: true */
  @get:JvmName("isRequired")
  val required: Boolean?
    get() = null

  val default: @NlsSafe String?
    get() = null

  val langType: Any?
    get() = null

  fun copy(kind: Kind? = null,
           type: Type? = null,
           required: Boolean? = null,
           default: String? = null,
           langType: Any? = null): PolySymbolHtmlAttributeValue =
    create(kind ?: this.kind, type ?: this.type,
           required ?: this.required, default ?: this.default,
           langType ?: this.langType)

  enum class Kind {
    /** Attribute value should be regarded as a plain string */
    PLAIN,

    /** Attribute value should be regarded as a complex expression with a result type */
    EXPRESSION,

    /** Attribute does not accept any value */
    NO_VALUE
  }

  enum class Type {
    BOOLEAN,
    NUMBER,
    STRING,
    ENUM,
    SYMBOL,
    COMPLEX,
    OF_MATCH
  }

  companion object {
    @JvmStatic
    fun create(kind: Kind? = null,
               type: Type? = null,
               required: Boolean? = null,
               default: String? = null,
               langType: Any? = null): PolySymbolHtmlAttributeValue =
      PolySymbolHtmlAttributeValueImpl(kind, type, required, default, langType)
  }

}