# SubSense Typography System

## Overview

The SubSense typography system is based on Tailwind CSS text sizes and weights, adapted for Jetpack Compose. It provides a comprehensive set of text styles for all UI elements in the app.

## Tailwind Size Mapping

| Tailwind Class | Size (px/rem) | Compose (sp) | Usage |
|---|---|---|---|
| **text-xs** | 12px / 0.75rem | 12.sp | Budget info, secondary labels, expense dates |
| **text-sm** | 14px / 0.875rem | 14.sp | Labels, descriptions, filter chips, muted text |
| **text-lg** | 18px / 1.125rem | 18.sp | Section headers, expense amounts, category totals |
| **text-xl** | 20px / 1.25rem | 20.sp | Top bar titles ("Expense Tracker", "Settings") |
| **text-2xl** | 24px / 1.5rem | 24.sp | Amount input field, dollar sign prefix |
| **text-3xl** | 30px / 1.875rem | 30.sp | Large summary amounts ($1,234.50) |

## Font Weights

| Tailwind Class | CSS Weight | Compose | Usage |
|---|---|---|---|
| **font-normal** | 400 | FontWeight.Normal | Regular body text |
| **font-medium** | 500 | FontWeight.Medium | Labels, category names, list items, top bar titles |
| **font-semibold** | 600 | FontWeight.SemiBold | Section headers, category labels, form titles |
| **font-bold** | 700 | FontWeight.Bold | Amounts, totals, expense values |

## Available Text Styles

### Display Styles (Hero/Large Text)

#### DisplayLarge
- **Size**: 30sp (text-3xl)
- **Weight**: Bold (700)
- **Line Height**: 36sp
- **Usage**: Large summary amounts ($1,234.50), main totals
- **Example**:
```kotlin
Text(
    text = "$1,234.50",
    style = MaterialTheme.typography.displayLarge
)
```

#### DisplayMedium
- **Size**: 24sp (text-2xl)
- **Weight**: Bold (700)
- **Line Height**: 32sp
- **Usage**: Amount input field, dollar sign prefix, large values
- **Example**:
```kotlin
Text(
    text = "$",
    style = MaterialTheme.typography.displayMedium
)
```

### Title Styles

#### TitleLarge
- **Size**: 20sp (text-xl)
- **Weight**: Medium (500)
- **Line Height**: 28sp
- **Usage**: Page titles ("Expense Tracker", "Settings"), top bar titles
- **Example**:
```kotlin
Text(
    text = "Expense Tracker",
    style = MaterialTheme.typography.titleLarge
)
```

#### TitleMedium
- **Size**: 18sp (text-lg)
- **Weight**: Medium (500)
- **Line Height**: 24sp
- **Usage**: Section subtitles, secondary titles
- **Example**:
```kotlin
Text(
    text = "Recent Expenses",
    style = MaterialTheme.typography.titleMedium
)
```

### Headline Styles

#### HeadlineLarge
- **Size**: 18sp (text-lg)
- **Weight**: SemiBold (600)
- **Line Height**: 24sp
- **Usage**: Section headers, main section titles
- **Example**:
```kotlin
Text(
    text = "This Month",
    style = MaterialTheme.typography.headlineLarge
)
```

#### HeadlineMedium
- **Size**: 18sp (text-lg)
- **Weight**: Medium (500)
- **Line Height**: 24sp
- **Usage**: Subsection headers, category headers
- **Example**:
```kotlin
Text(
    text = "Food & Dining",
    style = MaterialTheme.typography.headlineMedium
)
```

### Body Large Styles

#### BodyLargeBold
- **Size**: 18sp (text-lg)
- **Weight**: Bold (700)
- **Line Height**: 24sp
- **Usage**: Expense amounts, category totals, important values
- **Example**:
```kotlin
Text(
    text = "$245.99",
    style = BodyLargeBold, // Using direct import
    color = MaterialTheme.colorScheme.error
)
```

#### BodyLargeMedium
- **Size**: 18sp (text-lg)
- **Weight**: Medium (500)
- **Line Height**: 24sp
- **Usage**: Category totals, secondary amounts
- **Example**:
```kotlin
Text(
    text = "Total: $1,234.50",
    style = MaterialTheme.typography.bodyLarge
)
```

### Body Standard Styles

#### BodyMedium
- **Size**: 14sp (text-sm)
- **Weight**: Medium (500)
- **Line Height**: 20sp
- **Usage**: Standard labels, descriptions, filter chips, regular labels
- **Example**:
```kotlin
Text(
    text = "Category",
    style = MaterialTheme.typography.bodyMedium
)
```

#### BodyNormal
- **Size**: 14sp (text-sm)
- **Weight**: Normal (400)
- **Line Height**: 20sp
- **Usage**: Regular body text, descriptions
- **Example**:
```kotlin
Text(
    text = "This is a description of the expense",
    style = BodyNormal, // Using direct import
)
```

### Caption & Label Styles

#### CaptionMedium
- **Size**: 12sp (text-xs)
- **Weight**: Medium (500)
- **Line Height**: 16sp
- **Usage**: Small labels, secondary info, budget info
- **Example**:
```kotlin
Text(
    text = "Budget: $500",
    style = CaptionMedium, // Using direct import
)
```

#### CaptionNormal
- **Size**: 12sp (text-xs)
- **Weight**: Normal (400)
- **Line Height**: 16sp
- **Usage**: Expense dates, secondary labels, muted text
- **Example**:
```kotlin
Text(
    text = "Jan 15, 2024",
    style = CaptionNormal, // Using direct import
)
```

#### LabelMedium
- **Size**: 14sp (text-sm)
- **Weight**: Medium (500)
- **Line Height**: 20sp
- **Usage**: Labels, descriptions, filter chips, form labels
- **Example**:
```kotlin
Text(
    text = "Food & Dining",
    style = MaterialTheme.typography.labelMedium
)
```

## Usage Guide

### Method 1: Using MaterialTheme
```kotlin
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

@Composable
fun ExpenseItem() {
    Text(
        text = "Grocery Shopping",
        style = MaterialTheme.typography.headlineLarge
    )
    Text(
        text = "$45.99",
        style = MaterialTheme.typography.bodyLarge
    )
    Text(
        text = "Jan 15, 2024",
        style = MaterialTheme.typography.labelSmall
    )
}
```

### Method 2: Direct Import
```kotlin
import com.example.subsense.core.theme.DisplayLarge
import com.example.subsense.core.theme.CaptionMedium

@Composable
fun Summary() {
    Text(
        text = "$1,234.50",
        style = DisplayLarge
    )
    Text(
        text = "Monthly Total",
        style = CaptionMedium
    )
}
```

### Method 3: Combining with Colors
```kotlin
import androidx.compose.material3.MaterialTheme
import com.example.subsense.core.theme.Primary

@Composable
fun CategoryTotal() {
    Text(
        text = "Food",
        style = MaterialTheme.typography.headlineLarge,
        color = Primary
    )
    Text(
        text = "$345.67",
        style = MaterialTheme.typography.bodyLarge,
        color = Primary
    )
}
```

## Common Component Patterns

### Top Bar Title
```kotlin
Text(
    text = "Expense Tracker",
    style = MaterialTheme.typography.titleLarge,
    color = MaterialTheme.colorScheme.onPrimary
)
```

### Section Header
```kotlin
Text(
    text = "Recent Expenses",
    style = MaterialTheme.typography.headlineLarge,
    color = MaterialTheme.colorScheme.onBackground
)
```

### Expense Amount
```kotlin
Text(
    text = "$245.99",
    style = BodyLargeBold, // text-lg, font-bold
    color = Primary
)
```

### Secondary Label
```kotlin
Text(
    text = "Jan 15, 2024",
    style = MaterialTheme.typography.labelSmall,
    color = MaterialTheme.colorScheme.onSurfaceVariant
)
```

### Budget Info
```kotlin
Text(
    text = "Budget: $500 | Spent: $345",
    style = CaptionMedium,
    color = MaterialTheme.colorScheme.onSurfaceVariant
)
```

### Filter Chip
```kotlin
Text(
    text = "All Categories",
    style = MaterialTheme.typography.labelMedium,
    color = MaterialTheme.colorScheme.onSecondaryContainer
)
```

## Typography Hierarchy

```
Display Large (30sp, Bold)        - Hero amounts
    ↓
Display Medium (24sp, Bold)       - Large input values
    ↓
Title Large (20sp, Medium)        - Page titles, top bar
    ↓
Title Medium (18sp, Medium)       - Section subtitles
    ↓
Headline Large (18sp, SemiBold)   - Section headers
    ↓
Body Large (18sp, Bold/Medium)    - Expense amounts, totals
    ↓
Body Medium (14sp, Medium)        - Standard labels
    ↓
Body Normal (14sp, Normal)        - Regular body text
    ↓
Caption Medium (12sp, Medium)     - Small labels, info
    ↓
Caption Normal (12sp, Normal)     - Dates, secondary info
```

## Line Height Guidelines

- **Display Styles**: 1.2× font size
- **Title Styles**: 1.4× font size
- **Body Styles**: 1.4× font size
- **Caption Styles**: 1.33× font size

## Letter Spacing

- Most styles: 0.5.sp (0.5px)
- Display/Title Large: 0.15.sp
- Headline/Body Large: 0 or minimal

## Best Practices

1. **Consistency**: Always use typography from Material3 for consistency
2. **Hierarchy**: Use appropriate style levels for information hierarchy
3. **Readability**: Never reduce font size below 12sp for body text
4. **Color Contrast**: Ensure sufficient contrast with background colors
5. **Semantic Use**: Match style to content importance, not visual preference

## Migration from Hardcoded Text

### Before
```kotlin
Text(
    text = "Amount",
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold
)
```

### After
```kotlin
Text(
    text = "Amount",
    style = BodyLargeBold
)
```

---

For questions or typography updates, modify the `Type.kt` file and this reference will apply throughout the app.
