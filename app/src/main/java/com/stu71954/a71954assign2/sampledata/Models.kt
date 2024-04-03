package com.stu71954.a71954assign2.sampledata

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import kotlin.random.Random

data class MovieData(
    val name: String,
    val image: String,
    val certification: String,
    val description: String,
    val starring: Array<String>,
    val runningTimeMin: Int,
    val seatsRemaining: MutableState<Int>,
    val seatsSelected: MutableState<Int>,
)

val movies = listOf(
    MovieData(
        "IMAGINARY",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/f607e5c8-c8db-4dbb-92d0-dad9ab8c68c3_imaginary_posters_imaginary_1sheet_686x1016_712px.jpg?mw=450&rev=795a2eed0ad641b297101bd70e72eca7",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/15a.png?mw=25&mh=25&rev=fd3786da538c4502b4e4c02ea3c7b44e",
        "When Jessica (DeWanda Wise) moves back into her childhood home with her family, her youngest stepdaughter Alice develops an eerie attachment to a stuffed bear. (Horror)",
         arrayOf("Betty Buckley", "DeWanda Wise", "Tom Payne"),
        120,
         mutableIntStateOf(Random.nextInt(0, 16)),
         mutableIntStateOf(0),
        ),
    MovieData(
        "KUNG FU PANDA 4",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/a223aaeb-6a2d-4561-92f0-e3efa105a21e_kung-fu-panda-4_posters_kf4_intl_dgtl_payoff_1sheet_uk_712px.jpg?mw=450&rev=7239547d058742c7b4ee0899fe51c29e",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/pg.png?mw=25&mh=25&rev=be4a86333c51431593fef1189e30e84e",
        "After Po is tapped to become the Spiritual Leader of the Valley of Peace, he needs to find and train a new Dragon Warrior, while a wicked sorceress plans to re-summon all the master villains whom Po has vanquished to the spirit realm.",
        arrayOf("Jack Black", "Awkwafina", "Viola David", "Dustin Hoffman", "Bryan Cranston", "Mr. Beast"),
        120,
        mutableIntStateOf(Random.nextInt(0, 16)),
        mutableIntStateOf(0),
    ),
    MovieData(
        "GHOSTBUSTERS",
        "https://www.myvue.com/-/jssmedia/vuecinemas/film-and-events/feb-2024/ghostbusters-poster.jpg?mw=450&rev=890c7016efc4412293629c8d63844732",
        "https://www.myvue.com/-/jssmedia/vuecinemas/certificates/uk/12a.png?mw=25&mh=25&rev=b91ed3a02335433fb5f5becf370850dc",
        "In Ghostbusters: Frozen Empire, the Spengler family returns to where it all started – the iconic New York City firehouse – to team up with the original Ghostbusters.",
        arrayOf("Paul Rudd", "Bill Murray", "Finn Wolfhard", "Dan Aykroud", "Annie Potts", "Mckenna Grace", "Ernie Hudson"),
        120,
        mutableIntStateOf(Random.nextInt(0, 16)),
        mutableIntStateOf(0),
    ),
    MovieData(
        "GODZILLA VS KONG",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/7bf51248-5164-49ec-ab6f-090e904a263f_godzilla-x-kong-the-new-empire_posters_teaser---one-sheet_712px.jpg?mw=450&rev=013f431ef34d4bd98344d19d229a4345",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/12a.png?mw=25&mh=25&rev=d1b78b8f625a43b098703bf1bf397269",
        "The new installment in the Monsterverse puts the mighty Kong and the fearsome Godzilla against a colossal deadly threat hidden within our world.",
        arrayOf("Rebecca Hall", "Dan Stevens", "Brian Tyree Henry", "Fala Chen", "Kaylee Hottle", "Alex Ferns"),
        120,
        mutableIntStateOf(Random.nextInt(0, 16)),
        mutableIntStateOf(0),
    ),
    MovieData(
        "DUNE PART II",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/7a7a20aa-1064-46fd-96cc-4b271268f2c5_dune-part-ii_posters_one-sheet_712px.jpg?mw=450&rev=c61dcb539042435c973daaeeb97100b6",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/12a.png?mw=25&mh=25&rev=d1b78b8f625a43b098703bf1bf397269",
        "Paul Atreides unites with Chani and the Fremen while on a warpath of revenge against the conspirators who destroyed his family.",
        arrayOf("Timothée Chalamet", "Florence Pugh", "Zendaya" , "Souheila Yacoub", "Austin Butler"),
        120,
        mutableIntStateOf(Random.nextInt(0, 16)),
        mutableIntStateOf(0),
    ),
    MovieData(
        "MIGRATION",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/fddf86f4-a848-4ffd-9a05-b602edc77b70_migration_posters_mig_intl_dgtl_one_sheet_opt_1_landing_uk_712p.jpg?mw=450&rev=69acf0619d6946d596b112f278bf4bd5",
        "https://www.myvue.com/-/jssmedia/vuecinemas/img/certificates/ie/pg.png?mw=25&mh=25&rev=be4a86333c51431593fef1189e30e84e",
        "A family of ducks decides to leave the safety of a New England pond for an adventurous trip to Jamaica. However, their well-laid plans quickly go awry when they get lost and wind up in New York City.",
        arrayOf("Elizabeth Banks", "Danny DeVito", "Keegan-Michael Key", "Kumail Nanjiani", "Awkwafina"),
        120,
         mutableIntStateOf(Random.nextInt(0, 16)),
         mutableIntStateOf(0),
    ),
)

