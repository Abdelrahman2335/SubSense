package com.example.subsense.core.ui

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = LightColors.primary,
    onPrimary = LightColors.primaryForeground,
    primaryContainer = LightColors.primary.copy(alpha = 0.1f),
    onPrimaryContainer = LightColors.foreground,

    secondary = LightColors.secondary,
    onSecondary = LightColors.secondaryForeground,
    secondaryContainer = LightColors.secondary,
    onSecondaryContainer = LightColors.secondaryForeground,

    tertiary = LightColors.accent,
    onTertiary = LightColors.accentForeground,
    tertiaryContainer = LightColors.accent.copy(alpha = 0.1f),
    onTertiaryContainer = LightColors.accent,

    error = LightColors.destructive,
    onError = LightColors.destructiveForeground,
    errorContainer = LightColors.destructive.copy(alpha = 0.1f),
    onErrorContainer = LightColors.foreground,

    background = LightColors.background,
    onBackground = LightColors.foreground,

    surface = LightColors.card,
    onSurface = LightColors.cardForeground,
    surfaceVariant = LightColors.muted,
    onSurfaceVariant = LightColors.mutedForeground,

    outline = LightColors.border,
    outlineVariant = LightColors.input,
    scrim = Color.Black.copy(alpha = 0.32f)
)

@Composable
fun SubSenseTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
