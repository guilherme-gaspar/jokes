package com.guilhermegaspar.jokes.features.jokes.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.guilhermegaspar.jokes.common.utils.getRandomResourceChuckImage
import com.guilhermegaspar.jokes.features.jokes.domain.model.Joke
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.theme.bodyText
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.theme.lightOutline
import com.guilhermegaspar.jokes.features.jokes.presentation.ui.theme.primaryContainer

@Composable
fun JokeRow(joke: Joke) {
    Box(modifier = Modifier.padding(28.dp)) {
        Card(shape = RoundedCornerShape(8.dp), backgroundColor = primaryContainer) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(75.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = getRandomResourceChuckImage()),
                        contentDescription = "Avatar Chuck Norris",
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Identificador:",
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = joke.id,
                            style = MaterialTheme.typography.caption,
                            color = lightOutline
                        )
                    }
                    // TODO: Criar favorito
                    //IconButton(
                    //    onClick = { /*TODO*/ },
                    //    modifier = Modifier
                    //        .clip(CircleShape)
                    //        .background(surface)
                    //) {
                    //    Icon(
                    //        imageVector = Icons.Default.Star,
                    //        contentDescription = "Favorite",
                    //        tint = lightOutline
                    //    )
                    //}
                }
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = joke.value,
                        style = MaterialTheme.typography.body2,
                        maxLines = 3,
                        color = bodyText,
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 8.dp),
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}