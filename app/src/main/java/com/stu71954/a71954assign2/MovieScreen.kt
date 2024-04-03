package com.stu71954.a71954assign2

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.EventSeat
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.stu71954.a71954assign2.sampledata.movies
import com.stu71954.a71954assign2.ui.theme.ColorsApp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen( movieName: String?, navController: NavController) {
    val movie = movies.find { it.name == movieName }
    Text(text = "Movie Details:  ${movie?.name}")

    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = ColorsApp.primary,
                titleContentColor = ColorsApp.tertiary,
            ), title = {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,

                ) {
                    Text(
                        fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                       text= "${movie?.name}")
                }
            })
        },
        bottomBar = {
            BottomAppBar(
                containerColor = ColorsApp.secondary,
                contentColor = Color.White,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        text = "Select Seats: ",
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )

                    IconButton(onClick = {
                        if (movie?.seatsSelected?.value!! > 0) {
                            movie.seatsSelected.value--
                            movie.seatsRemaining.value++
                        }
                    }) {
                        Icon(Icons.Filled.Remove, contentDescription = "Remove Seat")
                    }
                    Text(
                        text = "${movie?.seatsSelected?.value}",

                        )
                    IconButton(onClick = {
                        if (movie?.seatsRemaining?.value!! > 0) {
                            movie.seatsSelected.value++
                            movie.seatsRemaining.value--
                        }
                    }) {
                        Icon(Icons.Filled.Add, contentDescription = "Add Seat")
                    }



                val iconColor = if (movie?.seatsRemaining?.value!! > 3) Color.Green else Color.Red
                if (movie.seatsRemaining.value != 0) {
                    Icon(
                        Icons.Filled.EventSeat,

                        contentDescription = "Seat Available",
                        tint = iconColor
                    )
                }

                    if (movie.seatsRemaining.value > 0) {
                        Text(
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                            text = "${movie.seatsRemaining.value}  Remaining Seats"
                        )
                    }


                }
            }
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(top = 60.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(ColorsApp.primary),


            ) {
            item {
                Image(
                    painter = rememberAsyncImagePainter(model = movie?.image),
                    contentDescription = movie?.name,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.FillBounds
                )
                Column(modifier = Modifier.padding(16.dp)) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${movie?.name }",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(android.graphics.Color.parseColor("#D3D3D3")),
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Image(
                            painter = rememberAsyncImagePainter(model = movie?.certification),
                            contentDescription = movie?.certification,
                            modifier = Modifier.size(26.dp),
                            contentScale = ContentScale.FillBounds
                        )
                        if (movie?.seatsRemaining?.value!! <= 3 && movie.seatsRemaining.value > 0) {
                            Text(
                                text = "Filling Fast",
                                color = Color.Red,
                                modifier = Modifier.padding(start = 16.dp),
                                fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                            )
                        }
                        if (movie.seatsRemaining.value == 0) {
                            Text(
                                text = "No seats available",
                                color = Color.Red,
                                modifier = Modifier.padding(start = 16.dp),
                                fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row {

                        Text(
                            text = "Starring ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#D3D3D3")),
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),

                        )
                        Text(
                            text = "Starring: ${movie?.starring?.joinToString()}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(android.graphics.Color.parseColor("#6E6E6E")),
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))

                    Row {

                        Text(
                            text = "Running Time ",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#D3D3D3")),
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        )
                        Text(
                            text = "${movie?.runningTimeMin} mins",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(android.graphics.Color.parseColor("#6E6E6E")),
                            fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "${movie?.description}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        maxLines = 10,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(bottom = 100.dp), // Add this line,
                        fontFamily = FontFamily(Font(resId = R.font.roboto_condensed_regular)),

                    )

                }
            }
        }
    }
}

