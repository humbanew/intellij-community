// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.uast.test.kotlin

import org.jetbrains.kotlin.idea.base.plugin.KotlinPluginMode
import org.jetbrains.uast.UFile
import org.junit.Test

class SimpleKotlinRenderLogTest : AbstractKotlinUastTest(), AbstractKotlinRenderLogTest {

    override val pluginMode: KotlinPluginMode
        get() = KotlinPluginMode.K1

    override fun check(testName: String, file: UFile) = super.check(testName, file)

    @Test
    fun testLocalDeclarations() = doTest("LocalDeclarations")

    @Test
    fun testSimple() = doTest("Simple")

    @Test
    fun testWhenIs() = doTest("WhenIs")

    @Test
    fun testDefaultImpls() = doTest("DefaultImpls")

    @Test
    fun testBitwise() = doTest("Bitwise")

    @Test
    fun testElvis() = doTest("Elvis")

    @Test
    fun testPropertyAccessors() = doTest("PropertyAccessors")

    @Test
    fun testPropertyInitializer() = doTest("PropertyInitializer")

    @Test
    fun testPropertyInitializerWithoutSetter() = doTest("PropertyInitializerWithoutSetter")

    @Test
    fun testAnnotationParameters() = doTest("AnnotationParameters")

    @Test
    fun testEnumValueMembers() = doTest("EnumValueMembers")

    @Test
    fun testEnumValuesConstructors() = doTest("EnumValuesConstructors")

    @Test
    fun testStringTemplate() = doTest("StringTemplate")

    @Test
    fun testStringTemplateComplex() = doTest("StringTemplateComplex")

    @Test
    fun testStringTemplateComplexForUInjectionHost() = doTest("StringTemplateComplexForUInjectionHost")

    @Test
    fun testQualifiedConstructorCall() = doTest("QualifiedConstructorCall")

    @Test fun testLocalVariableWithAnnotation() = doTest("LocalVariableWithAnnotation")

    @Test fun testPropertyWithAnnotation() = doTest("PropertyWithAnnotation")

    @Test fun testIfStatement() = doTest("IfStatement")

    @Test fun testInnerClasses() = doTest("InnerClasses")

    @Test fun testSimpleScript() = doTest("SimpleScript") { testName, file -> check(testName, file, false) }

    @Test fun testDestructuringDeclaration() = doTest("DestructuringDeclaration")

    @Test fun testDefaultParameterValues() = doTest("DefaultParameterValues")

    @Test fun testParameterPropertyWithAnnotation() = doTest("ParameterPropertyWithAnnotation")

    @Test fun testParametersWithDefaultValues() = doTest("ParametersWithDefaultValues")

    @Test
    fun testUnexpectedContainer() = doTest("UnexpectedContainerException")

    @Test
    fun testWhenStringLiteral() = doTest("WhenStringLiteral")

    @Test
    fun testWhenAndDestructing() = doTest("WhenAndDestructing") { testName, file -> check(testName, file, false) }

    @Test
    fun testSuperCalls() = doTest("SuperCalls")

    @Test
    fun testConstructors() = doTest("Constructors")

    @Test
    fun testReceiverFun() = doTest("ReceiverFun")

    @Test
    fun testAnonymous() = doTest("Anonymous")

    @Test
    fun testAnnotationComplex() = doTest("AnnotationComplex")

    @Test
    fun testParametersDisorder() = doTest("ParametersDisorder") { testName, file ->
        // disabled due to inconsistent parents for 2-receivers call (KT-22344)
        check(testName, file, false)
    }

    @Test
    fun testLambdas() = doTest("Lambdas")

    @Test
    fun testTypeReferences() = doTest("TypeReferences")

    @Test
    fun testDelegate() = doTest("Delegate")

    @Test
    fun testConstructorDelegate() = doTest("ConstructorDelegate")

    @Test
    fun testLambdaReturn() = doTest("LambdaReturn")

    @Test
    fun testReified() = doTest("Reified")

    @Test
    fun testReifiedReturnType() = doTest("ReifiedReturnType")

    @Test
    fun testReifiedParameters() = doTest("ReifiedParameters")

    @Test
    fun testSuspend() = doTest("Suspend")

    @Test
    fun testDeprecatedHidden() = doTest("DeprecatedHidden")

    @Test
    fun testTryCatch() = doTest("TryCatch")

    @Test
    fun testAnnotatedExpressions() = doTest("AnnotatedExpressions")

    @Test
    fun testNonTrivialIdentifiers() = doTest("NonTrivialIdentifiers")

    @Test
    fun testTypeAliasExpansionWithOtherAliasInArgument() = doTest("TypeAliasExpansionWithOtherAliasInArgument")

    @Test
    fun testComments() = doTest("Comments")

    @Test
    fun testBrokenDataClass() = doTest("BrokenDataClass")
}