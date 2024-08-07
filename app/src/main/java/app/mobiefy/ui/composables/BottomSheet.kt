package app.mobiefy.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.mobiefy.R
import app.mobiefy.data.FavouriteLocation
import app.mobiefy.ui.theme.brightShade
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.white

val favLocations = listOf(
    FavouriteLocation(
        title = "Casa",
        icon = R.drawable.ic_home
    ),
    FavouriteLocation(
        title = "Trabalho",
        icon = R.drawable.ic_work
    ),
    FavouriteLocation(
        title = "Vó",
        icon = R.drawable.ic_heart
    ),
    FavouriteLocation(
        title = "Adicionar",
        icon = R.drawable.ic_plus
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(pageContent: Unit) {
    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 150.dp,
        sheetContainerColor = white,
        sheetDragHandle = { DragBar() },
        sheetContent = {
            BottomSheetContent()
        }) {
        pageContent
    }
}

@Composable
fun BottomSheetContent() {
    Column(modifier = Modifier.padding(horizontal = 23.dp)) {
        CustomSearchBar()
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(brightShade)
        ) {
            Row {
                Spacer(modifier = Modifier.width(10.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(favLocations.size) { index ->
                        FavLocationsBox(index)
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
fun FavLocationsBox(index: Int) {
    val location = favLocations[index]
    Column {
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            IconRound(text = location.title, icon = painterResource(id = location.icon))
        }
        Spacer(modifier = Modifier.height(13.dp))
    }

}

@Composable
fun DragBar() {
    Icon(
        painter = painterResource(id = R.drawable.drag_bar),
        contentDescription = "Drag bar",
        tint = primary,
        modifier = Modifier
            .padding(vertical = 15.dp)
            .width(80.dp)
            .height(7.dp)
    )
}
