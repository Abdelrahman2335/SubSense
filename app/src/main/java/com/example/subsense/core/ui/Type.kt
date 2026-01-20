package com.example.subsense.core.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ===== TAILWIND TEXT SIZE MAPPING =====
// text-xs:   12px / 0.75rem  - Budget info text, secondary labels, expense dates
// text-sm:   14px / 0.875rem - Labels, descriptions, filter chips, muted text
// text-lg:   18px / 1.125rem - Section headers, expense amounts, category totals
// text-xl:   20px / 1.25rem  - Top bar titles ("Expense Tracker", "Settings", etc.)
// text-2xl:  24px / 1.5rem   - Amount input field, dollar sign prefix
// text-3xl:  30px / 1.875rem - Large summary amounts ($1,234.50)

// ===== FONT WEIGHTS =====
// font-normal:   400 - Regular body text
// font-medium:   500 - Labels, category names, list items, top bar titles
// font-semibold: 600 - Section headers, category labels, form titles
// font-bold:     700 - Amounts, totals, expense values

// ===== DISPLAY & HERO STYLES =====
// Display Large: text-3xl font-bold
val DisplayLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,      // 700
    fontSize = 30.sp,                  // text-3xl
    lineHeight = 36.sp,
    letterSpacing = 0.sp
)

// Display Medium: text-2xl font-bold (for secondary large text)
val DisplayMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,      // 700
    fontSize = 24.sp,                  // text-2xl
    lineHeight = 32.sp,
    letterSpacing = 0.sp
)

// ===== TITLE STYLES =====
// Title Large: text-xl font-medium/semibold (Page titles, top bar titles)
val TitleLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,    // 500
    fontSize = 20.sp,                  // text-xl
    lineHeight = 28.sp,
    letterSpacing = 0.15.sp
)

// Title Medium: text-lg font-medium (Section subtitles)
val TitleMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,    // 500
    fontSize = 18.sp,                  // text-lg
    lineHeight = 24.sp,
    letterSpacing = 0.1.sp
)

// ===== HEADLINE STYLES =====
// Headline Large: text-lg font-semibold (Section headers)
val HeadlineLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.SemiBold,  // 600
    fontSize = 18.sp,                  // text-lg
    lineHeight = 24.sp,
    letterSpacing = 0.sp
)

// Headline Medium: text-lg font-medium (Subsection headers)
val HeadlineMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,    // 500
    fontSize = 18.sp,                  // text-lg
    lineHeight = 24.sp,
    letterSpacing = 0.sp
)

// ===== BODY LARGE STYLES =====
// Body Large Bold: text-lg font-bold (Expense amounts, totals)
val BodyLargeBold = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Bold,      // 700
    fontSize = 18.sp,                  // text-lg
    lineHeight = 24.sp,
    letterSpacing = 0.sp
)

// Body Large Medium: text-lg font-medium (Category totals)
val BodyLargeMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,    // 500
    fontSize = 18.sp,                  // text-lg
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

// ===== BODY STANDARD STYLES =====
// Body Medium: text-sm font-medium (Standard labels and text)
val BodyMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,    // 500
    fontSize = 14.sp,                  // text-sm
    lineHeight = 20.sp,
    letterSpacing = 0.25.sp
)

// Body Normal: text-sm font-normal (Regular body text)
val BodyNormal = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,    // 400
    fontSize = 14.sp,                  // text-sm
    lineHeight = 20.sp,
    letterSpacing = 0.5.sp
)

// ===== CAPTION & LABEL STYLES =====
// Caption Medium: text-xs font-medium (Small labels, secondary info)
val CaptionMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,    // 500
    fontSize = 12.sp,                  // text-xs
    lineHeight = 16.sp,
    letterSpacing = 0.4.sp
)

// Caption Normal: text-xs font-normal (Budget info, expense dates)
val CaptionNormal = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,    // 400
    fontSize = 12.sp,                  // text-xs
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)

// Label Medium: text-sm font-medium (Labels, descriptions, filter chips)
val LabelMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,    // 500
    fontSize = 14.sp,                  // text-sm
    lineHeight = 20.sp,
    letterSpacing = 0.5.sp
)

// ===== Material3 Typography Configuration =====
val Typography = Typography(
    // Display Styles
    displayLarge = DisplayLarge,
    displayMedium = DisplayMedium,

    // Title Styles
    titleLarge = TitleLarge,
    titleMedium = TitleMedium,

    // Headline Styles
    headlineLarge = HeadlineLarge,
    headlineMedium = HeadlineMedium,

    // Body Styles
    bodyLarge = BodyLargeMedium,
    bodyMedium = BodyMedium,

    // Label/Caption Styles
    labelMedium = LabelMedium,
    labelSmall = CaptionMedium
)