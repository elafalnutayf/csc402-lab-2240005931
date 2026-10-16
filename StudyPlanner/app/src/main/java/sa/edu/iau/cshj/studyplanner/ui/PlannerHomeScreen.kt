package sa.edu.iau.cshj.studyplanner.ui
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
data class PlannerUiState(
    val greeting: String = "Hi Elaf!",
    val totalTasks: Int = 7,
    val doneTasks: Int = 3
)
@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onMarkDone: () -> Unit,
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

        Button(
            onClick = onMarkDone
        ) {
            Text("Mark one done")
        }
    }
}
@Composable
fun PlannerHomeRoute() {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                greeting = "Hi Elaf!",
                totalTasks = 7,
                doneTasks = 3
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
        }
    )
}
@Preview(showBackground = true, name = "Nothing done yet")
@Composable
private fun PlannerHomeEmptyPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Hi Elaf!",
                totalTasks = 7,
                doneTasks = 0
            ),
            onMarkDone = {}
        )
    }
}
@Preview(showBackground = true, name = "Everything done")
@Composable
private fun PlannerHomeCompletedPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Hi Elaf!",
                totalTasks = 7,
                doneTasks = 7
            ),
            onMarkDone = {}
        )
    }
}