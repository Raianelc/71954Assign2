package com.stu71954.a71954assign2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.stu71954.a71954assign2.sampledata.movies
import com.stu71954.a71954assign2.ui.theme.ColorsApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ColorsApp.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = "https://www.myvue.com/-/jssmedia/global/img/logo-header-vue.png?mw=90&mh=40&rev=5d978a6ad9c04cac97869073febdf5c4"),
                            contentDescription = "Logo",
                            modifier = Modifier.size(85.dp),
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = ColorsApp.secondary,
                contentColor = ColorsApp.tertiary,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                        text = "VUE CINEMA",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                )
            }
        },
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onBackground),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                itemsIndexed(movies) { _, movie ->
                    Card(
                        modifier = Modifier.padding(5.dp).fillMaxWidth(),
                        onClick = { navController.navigate("movieScreen/${movie.name}") }
                    ) {
                        Column (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(model = movie.image),
                                contentDescription = movie.description,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.fillMaxSize().size(300.dp)

                            )

                        }
                    }
                }
            }
        }
    }
}


