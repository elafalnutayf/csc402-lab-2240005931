package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val greeting: String = "Hi Elaf!",
    val totalTasks: Int = 7,
    val doneTasks: Int = 3,
    val tasks: List<String> = emptyList()
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onMarkDone: () -> Unit,
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(uiState.greeting)

        Text("${uiState.doneTasks} of ${uiState.totalTasks} tasks done")

        Button(onClick = onMarkDone) {
            Text("Mark one done")
        }

        Text("Tasks")

        uiState.tasks.forEach { title ->
            Button(onClick = { onTaskClick(title) }) {
                Text(title)
            }
        }
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit
) {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                greeting = "Hi Elaf!",
                totalTasks = 7,
                doneTasks = 3,
                tasks = listOf(
                    "Review Kotlin",
                    "Study Navigation",
                    "Lab 5 report"
                )
            )
        )
    }

    PlannerHomeScreen(
        uiState = uiState,
        onMarkDone = {
            if (uiState.doneTasks < uiState.totalTasks) {
                uiState = uiState.copy(
                    doneTasks = uiState.doneTasks + 1
                )
            }
        },
        onTaskClick = onTaskClick
    )
}

@Preview(showBackground = true, name = "Nothing done yet")
@Composable
private fun PlannerHomeEmptyPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                doneTasks = 0,
                tasks = listOf(
                    "Review Kotlin",
                    "Study Navigation",
                    "Lab 5 report"
                )
            ),
            onMarkDone = {},
            onTaskClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Everything done")
@Composable
private fun PlannerHomeCompletedPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                doneTasks = 7,
                tasks = listOf(
                    "Review Kotlin",
                    "Study Navigation",
                    "Lab 5 report"
                )
            ),
            onMarkDone = {},
            onTaskClick = {}
        )
    }
}