package sa.edu.iau.cshj.lab04.ui
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
import sa.edu.iau.cshj.lab04.ui.theme.Lab04AttendanceTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
data class AttendanceUiState(
    val sessionTitle: String = "",
    val checkedInCount: Int = 0,
    val isCheckedIn: Boolean = false
)
@Composable
fun AttendanceScreen(
    uiState: AttendanceUiState,
    onCheckIn: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(uiState.sessionTitle)

        Text("Checked in: ${uiState.checkedInCount}")

        Button(
            onClick = onCheckIn,
            enabled = !uiState.isCheckedIn
        ) {
            Text("Check in")
        }
    }
}
@Composable
fun AttendanceRoute() {
    var uiState by remember {
        mutableStateOf(
            AttendanceUiState(
                sessionTitle = "CSC 402 - Week 4",
                checkedInCount = 12
            )
        )
    }

    AttendanceScreen(
        uiState = uiState,
        onCheckIn = {
            uiState.checkedInCount + 1
        }
    )
}
@Preview(showBackground = true, name = "Not checked in yet")
@Composable
private fun AttendanceScreenPreview() {
    Lab04AttendanceTheme {
        AttendanceScreen(
            uiState = AttendanceUiState(
                sessionTitle = "CSC 402 - Week 4",
                checkedInCount = 12,
                isCheckedIn = false
            ),
            onCheckIn = {}
        )
    }
}
@Preview(showBackground = true, name = "Already checked in")
@Composable
private fun AttendanceScreenCheckedInPreview() {
    Lab04AttendanceTheme {
        AttendanceScreen(
            uiState = AttendanceUiState(
                sessionTitle = "CSC 402 - Week 4",
                checkedInCount = 12,
                isCheckedIn = true
            ),
            onCheckIn = {}
        )
    }
}