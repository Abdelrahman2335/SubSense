# Typography Quick Reference

## TL;DR - Common Usage Patterns

### Page/Section Titles
```kotlin
Text(
    text = "Expense Tracker",
    style = MaterialTheme.typography.titleLarge  // 20sp, Medium
)
```

### Section Headers
```kotlin
Text(
    text = "Recent Expenses",
    style = MaterialTheme.typography.headlineLarge  // 18sp, SemiBold
)
```

### Large Amounts (Hero)
```kotlin
Text(
    text = "$1,234.50",
    style = MaterialTheme.typography.displayLarge  // 30sp, Bold
)
```

### Expense Amounts
```kotlin
Text(
    text = "$245.99",
    style = BodyLargeBold  // 18sp, Bold
)
```

### Standard Labels
```kotlin
Text(
    text = "Category",
    style = MaterialTheme.typography.bodyMedium  // 14sp, Medium
)
```

### Secondary Info (Dates, Budgets)
```kotlin
Text(
    text = "Jan 15, 2024",
    style = MaterialTheme.typography.labelSmall  // 12sp, Medium
)
```

## Style Guide by Component

| Component | Style | Size | Weight |
|-----------|-------|------|--------|
| Page Title | titleLarge | 20sp | Medium |
| Section Header | headlineLarge | 18sp | SemiBold |
| Category Title | headlineMedium | 18sp | Medium |
| Expense Amount | BodyLargeBold | 18sp | Bold |
| Category Total | BodyLargeMedium | 18sp | Medium |
| Label Text | bodyMedium | 14sp | Medium |
| Filter Chip | labelMedium | 14sp | Medium |
| Description | BodyNormal | 14sp | Normal |
| Budget Info | CaptionMedium | 12sp | Medium |
| Expense Date | CaptionNormal | 12sp | Normal |
| Large Input $ | DisplayMedium | 24sp | Bold |
| Hero Amount | DisplayLarge | 30sp | Bold |

## Import Examples

### From Material Theme
```kotlin
import androidx.compose.material3.MaterialTheme

style = MaterialTheme.typography.titleLarge
style = MaterialTheme.typography.headlineLarge
style = MaterialTheme.typography.bodyMedium
style = MaterialTheme.typography.labelSmall
```

### Direct Imports
```kotlin
import com.example.subsense.core.theme.DisplayLarge
import com.example.subsense.core.theme.BodyLargeBold
import com.example.subsense.core.theme.CaptionMedium

style = DisplayLarge        // 30sp, Bold
style = BodyLargeBold       // 18sp, Bold
style = CaptionMedium       // 12sp, Medium
```

## Size Quick Reference
- **30sp** = text-3xl (Hero amounts)
- **24sp** = text-2xl (Large input)
- **20sp** = text-xl (Page titles)
- **18sp** = text-lg (Headers, amounts)
- **14sp** = text-sm (Labels, standard text)
- **12sp** = text-xs (Captions, dates)

## Weight Quick Reference
- **Bold (700)** = Amounts, totals, important values
- **SemiBold (600)** = Section headers
- **Medium (500)** = Labels, standard text
- **Normal (400)** = Body text, descriptions

---

See `TYPOGRAPHY_GUIDE.md` for complete reference.
