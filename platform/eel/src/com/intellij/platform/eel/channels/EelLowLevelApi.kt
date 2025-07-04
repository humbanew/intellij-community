// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.eel.channels

import org.jetbrains.annotations.ApiStatus

@MustBeDocumented
@Retention(value = AnnotationRetention.BINARY)
@RequiresOptIn(
  level = RequiresOptIn.Level.WARNING,
  message = "This function might send only part of the buffer. Consider using `sendWholeBuffer` instead"
)
@ApiStatus.Experimental
annotation class EelSendApi