/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.mongodb.core

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlin.reflect.KClass

/**
 * Extension for [ReactiveMapReduceOperation.mapReduce] providing a [KClass] based variant.
 *
 * @author Christoph Strobl
 * @since 2.1
 */
@Deprecated("Since 2.2, use the reified variant", replaceWith = ReplaceWith("mapReduce<T>()"))
fun <T : Any> ReactiveMapReduceOperation.mapReduce(entityClass: KClass<T>): ReactiveMapReduceOperation.MapReduceWithMapFunction<T> =
		mapReduce(entityClass.java)

/**
 * Extension for [ReactiveMapReduceOperation.mapReduce] leveraging reified type parameters.
 *
 * @author Christoph Strobl
 * @since 2.1
 */
inline fun <reified T : Any> ReactiveMapReduceOperation.mapReduce(): ReactiveMapReduceOperation.MapReduceWithMapFunction<T> =
		mapReduce(T::class.java)

/**
 * Extension for [ReactiveMapReduceOperation.MapReduceWithProjection.as] providing a [KClass] based variant.
 *
 * @author Christoph Strobl
 * @since 2.1
 */
@Deprecated("Since 2.2, use the reified variant", replaceWith = ReplaceWith("asType<T>()"))
fun <T : Any> ReactiveMapReduceOperation.MapReduceWithProjection<*>.asType(resultType: KClass<T>): ReactiveMapReduceOperation.MapReduceWithQuery<T> =
		`as`(resultType.java)

/**
 * Extension for [ReactiveMapReduceOperation.MapReduceWithProjection.as] leveraging reified type parameters.
 *
 * @author Christoph Strobl
 * @since 2.1
 */
inline fun <reified T : Any> ReactiveMapReduceOperation.MapReduceWithProjection<*>.asType(): ReactiveMapReduceOperation.MapReduceWithQuery<T> =
		`as`(T::class.java)


/**
 * Coroutines [Flow] variant of [ReactiveMapReduceOperation.TerminatingMapReduce.all].
 *
 * @author Sebastien Deleuze
 * @since 2.2
 */
@ExperimentalCoroutinesApi
fun <T : Any> ReactiveMapReduceOperation.TerminatingMapReduce<T>.flow(): Flow<T> =
		all().asFlow()
